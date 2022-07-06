package com.wugui.datax.admin.tool.datax.writer;

import java.util.Map;

/**
 * kingbasees writer构建类
 *
 * @author huangjj95
 * @ClassName KingbaseESWriter
 * @Version 1.0
 * @since 2022/6/30 15:30
 */
public class KingbaseESWriter extends BaseWriterPlugin implements DataxWriterInterface {
    @Override
    public String getName() {
        return "kingbaseeswriter";
    }


    @Override
    public Map<String, Object> sample() {
        return null;
    }
}
