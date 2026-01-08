package cn.lixx.designpatterns.iterator.page;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 分页迭代器，每次返回指定数量（一页）的元素。
 * @param <T> 列表中元素的类型。
 */
public class PageIterator<T> implements Iterator<List<T>> {
    private List<T> data;
    private int pageSize;
    private int cursor;

    public PageIterator(List<T> data, int pageSize) {
        if (data == null) {
            throw new IllegalArgumentException("数据列表不能为空");
        }
        if (pageSize <= 0) {
            throw new IllegalArgumentException("页面大小必须大于0");
        }
        this.data = data;
        this.pageSize = pageSize;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < data.size();
    }

    @Override
    public List<T> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int end = Math.min(cursor + pageSize, data.size());
        List<T> page = data.subList(cursor, end);
        cursor = end;
        return page;
    }
}