package com.janita.video.code.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import java.util.HashMap;

/**
 * Created by Janita on 2017-05-07 20:51
 */
public class ProvincePartitioner extends Partitioner<Text, FlowBean> {

    private static HashMap<String, Integer> provinceDict = new HashMap<>();

    static {
        provinceDict.put("138", 0);
        provinceDict.put("137", 1);
        provinceDict.put("138", 2);
        provinceDict.put("139", 3);
    }

    @Override
    public int getPartition(Text key, FlowBean value, int numPartitions) {
        String prefix = key.toString().substring(0, 3);
        return provinceDict.get(prefix);
    }
}
