package com.michael.sweet.heart.common.mp;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 默认的分页对象
 *
 * @author Arnold.zhao <a href="mailto:13949123615@163.com"/>
 * @create 2019-04-30
 */
public class PageInfo<K> extends Page<K> {

    public PageInfo() {
        //默认参数处理

    }

    /*
    ***********************************前端确认对应的返回结果集************************
    private List<K> data;
    public List<K> records;

    @Override
    public List<K> getRecords() {
        return this.records;
    }

    @Override
    public Page<K> setRecords(List<K> records) {
        this.records = records;
        this.data = records;
        return this;
    }

    public List<K> getData() {
        return data;
    }

    public void setData(List<K> data) {
        this.data = data;
    }
    */
}
