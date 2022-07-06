package com.wugui.datax.admin.tool.datax.reader;


import java.util.Map;

/**
 * kingbasees reader 构建类
 *
 * @author huangjj95
 * @ClassName KingbaseESReader
 * @Version 1.0
 * @since 2022/6/30 15:30
 */
public class KingbaseESReader extends BaseReaderPlugin implements DataxReaderInterface {
    @Override
    public String getName() {
        return "kingbaseesreader";
    }


    @Override
    public Map<String, Object> sample() {
        return null;
    }
}
