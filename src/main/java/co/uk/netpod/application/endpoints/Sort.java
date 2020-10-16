package co.uk.netpod.application.endpoints;

import java.util.List;
import java.util.Map;

public class Sort {
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sort{");
        sb.append("sort=").append(sort);
        sb.append('}');
        return sb.toString();
    }
    
    private List<Map<String, String>> sort;
    
    public List<Map<String, String>> getSort() {
        return sort;
    }
    
    public void setSort(final List<Map<String, String>> pSort) {
        sort = pSort;
    }
}
