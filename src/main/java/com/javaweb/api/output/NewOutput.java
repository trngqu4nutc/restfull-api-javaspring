package com.javaweb.api.output;

import com.javaweb.dto.NewDTO;

import java.util.ArrayList;
import java.util.List;

public class NewOutput {

    private int page;
    private int totalPage;
    private List<NewDTO> lstResult = new ArrayList<>();

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<NewDTO> getLstResult() {
        return lstResult;
    }

    public void setLstResult(List<NewDTO> lstResult) {
        this.lstResult = lstResult;
    }
}
