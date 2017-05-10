package com.janita.video.code.flow;

import com.janita.video.code.mapreduce.Consts;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by Janita on 2017-05-07 18:30
 */
public class FlowBean implements WritableComparable<FlowBean>{

    private Long upFlow;

    private Long dFlow;

    private Long sumFlow;

    public FlowBean() {
    }

    public FlowBean(Long upFlow, Long dFlow) {
        this.upFlow = upFlow;
        this.dFlow = dFlow;
        this.sumFlow = upFlow + dFlow;
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

    public Long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(Long sumFlow) {
        this.sumFlow = sumFlow;
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
        out.writeLong(upFlow);
        out.writeLong(dFlow);
        out.writeLong(sumFlow);
    }

    /**
     * 反序列化
     * 反序列化顺序与序列化顺序一致
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        upFlow = in.readLong();
        dFlow = in.readLong();
        sumFlow = in.readLong();
    }

    @Override
    public String toString() {
        return upFlow + Consts.ENTER + dFlow + Consts.ENTER + sumFlow;
    }

    @Override
    public int compareTo(FlowBean o) {

        return this.sumFlow > o.getSumFlow() ? -1 : 1 ;
    }
}
