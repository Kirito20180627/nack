package com.ldy.common.utils.csv;

import com.ldy.common.exception.UtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * csv文件导出和导入
 */
public class CSVUtil {

    private final static Logger logger = LoggerFactory.getLogger(CSVUtil.class);

    /**
     * csv文件列分隔符
     */
    private static final String CSV_COLUMN_SEPARATOR = ",";

    /**
     * 换行符
     */
    private static final String CSV_RN = "\r\n";

    /**
     *
     * @param dataList 集合数据
     * @param colNames 表头数据
     * @param mapKey 查找的对应数据
     * @param os 文件输出流
     * @return
     * @throws UtilException
     */
    public static boolean exportCSV(List<Map<String, Object>> dataList, String colNames, String mapKey, OutputStream os) throws UtilException{
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String[] colNamesArr = colNames.split(",");
            String[] mapKeyArr = mapKey.split(",");

            /**封装列头*/
            for (String aColName : colNamesArr){
                stringBuilder.append(aColName).append(CSV_COLUMN_SEPARATOR);
            }
            stringBuilder.append(CSV_RN);

            /**封装数据*/
            if (dataList != null){
                for (Map<String, Object> map : dataList){
                    for (String aMapKey : mapKeyArr){
                        map.put(aMapKey, StringUtils.isEmpty(map.get(aMapKey)) ? "" : map.get(aMapKey));
                        String dataStr = map.get(aMapKey).toString();

                        if (map.get(aMapKey).toString().contains(",")){
                            if (map.get(aMapKey).toString().contains("\"")){
                                dataStr = map.get(aMapKey).toString().replace("\"","\"\"");
                            }
                            dataStr = "\"" + dataStr + "\"";
                            stringBuilder.append(dataStr).append(CSV_COLUMN_SEPARATOR);
                        }else {
                            if (map.get(aMapKey).toString().contains(CSV_RN)){
                                dataStr = "\"" + dataStr + "\"";
                            }
                            stringBuilder.append(dataStr).append(CSV_COLUMN_SEPARATOR);
                        }
                    }
                    stringBuilder.append(CSV_RN);
                }
            }
            os.write(stringBuilder.toString().getBytes("GBK"));
            os.flush();
            return true;

        }catch (Exception e){
            logger.info("导出csv文件出错",e);
            throw new UtilException("导出csv文件出错");
        }finally {
            if (os != null){
                try {
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读取CSV数据（包括数据去重）
     * @param colNames 表头
     * @param mapKey 每一行里查找对应列的数据
     * @param file 文件
     * @return
     * @throws UtilException
     */
    public  static List<Map<String, Object>> readCSV(String colNames, String mapKey, MultipartFile file) throws UtilException{
        List<Map<String, Object>> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        try {
            String[] colNamesArr = colNames.split(",");
            String[] mapKeyArr = mapKey.split(",");
            if (colNamesArr.length != mapKeyArr.length){
                throw  new UtilException("表格列与属性个数不一致");
            }
            int length = colNamesArr.length;

            /**对file文件进行解析*/
            if ( file != null){
                try {
                    InputStream inputStream = file.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"gbk"));

                    /**获取第一行信息*/
                    String line = reader.readLine().trim();
                    while (line.length() != colNames.length()){
                        if (line.charAt(line.length()-1) == ','){
                            line = line.substring(0,line.length()-1).trim();
                        }else {
                            throw new UtilException("文件内容格式错误，请下载模板填写");
                        }
                    }
                    if ( ! colNames.equals(line)){
                        throw new UtilException("文件内容格式错误，请下载模板填写");
                    }
                    String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$";
                    while ((line = reader.readLine()) != null){
                        String[] item = line.split(csvSplitBy,-1);
                        if (item.length > length){
                            item = Arrays.copyOfRange(item,0,length-1);
                        }
                        while (item.length != length){
                            line += reader.readLine();
                            item = line.split(csvSplitBy,-1);
                        }
                        if (set.contains(line)){
                            continue;
                        }else {
                            set.add(line);
                        }
                        Map<String, Object> map = new HashMap<>();
                        for (int i = 0; i < length; i++){
                            item[i] = item[i].trim();
                            item[i].replace("\"\"","\"");
                            if ( ! item[i].isEmpty() && item[i].charAt(0) == '"' && item[i].charAt(item[i].length()-1) == '"'){
                                item[i] = item[i].substring(1,item[i].length()-1);
                            }
                            map.put(mapKeyArr[i],item[i]);
                        }
                        list.add(map);
                    }
                }catch (Exception ex){
                    throw new UtilException(ex);
                }
            }else {
                throw new UtilException("文件不能为空");
            }
        }catch (Exception ex){
            throw new UtilException(ex);
        }
        return list;
    }

    /**
     * 设置响应头信息
     * @param fileName
     * @param response
     * @throws UnsupportedEncodingException
     */
    public static void responseSetProperties(String fileName, HttpServletResponse response) throws UnsupportedEncodingException{
        /**设置文件名*/
        String f = fileName + ".csv";
        /**读取字符编码**/
        String utf = "UTF-8";
        /**设置相应**/
        response.setContentType("application/ms-txt.numberformat:@");
        response.setCharacterEncoding(utf);
        response.setHeader("Pragma","public");
        response.setHeader("Cache-Control","max-age=30");
        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(f,utf));

    }


}
