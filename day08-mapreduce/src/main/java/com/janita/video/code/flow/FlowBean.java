package com.janita.video.code.flow;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 18:30
 */
public class FlowBean implements Writable{

    private Long upFlow;

    private Long dFlow;

    public FlowBean(Long upFlow, Long dFlow) {
        this.upFlow = upFlow;
        this.dFlow = dFlow;
    }

    public Long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(Long upFlow) {
        this.upFlow = upFlow;
    }

    public Long getdFlow() {
        return dFlow;
    }

    public void setdFlow(Long dFlow) {
        this.dFlow = dFlow;
    }

    /**
     * 序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {


    }

    /**
     * 反序列化
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {

    }
}
