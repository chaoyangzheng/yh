package com.yh.utils;

/**
 * @author SHIGUANGYI
 * @date 2019/10/4
 * PageHelper工具类，用于初始化分页参数
 */
public class PageHelperUtil {
    /**
     * 当前页码，默认1
     */
    private Integer pageNum;
    /**
     * 每页条数，默认10
     */
    private Integer pageSize;
    /**
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 因首页分页查询需要，额外添加了总类别id，默认0
     * 0=全部，1=水彩，2=素描，3=彩铅，4=油画
     */
    private Integer typeId;


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @return 参数已初始化的PageHelperUtil对象，默认pageNum=1，pageSize=10
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 初始化分页参数，默认pageNum=1，pageSize=10
     */
    public static PageHelperUtil initPageHelperParam(Integer pageNum, Integer pageSize) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }

        PageHelperUtil pageHelperUtil = new PageHelperUtil();
        pageHelperUtil.pageNum = pageNum;
        pageHelperUtil.pageSize = pageSize;

        return pageHelperUtil;
    }

    /**
     * @param pageNum  当前页码
     * @param pageSize 每页条数
     * @param typeId 总类别id，0=全部，1=水彩，2=素描，3=彩铅，4=油画
     * @return 参数已初始化的PageHelperUtil对象，默认pageNum=1，pageSize=10，typeId=0
     * @author SHIGUANGYI
     * @date 2019/10/4
     * 初始化分页参数，默认pageNum=1，pageSize=10，typeId=0
     */
    public static PageHelperUtil initPageHelperParam(Integer pageNum, Integer pageSize, Integer typeId) {
        if (null == pageNum || pageNum < 1) {
            pageNum = 1;
        }
        if (null == pageSize || pageSize < 1) {
            pageSize = 10;
        }
        if (null == typeId || typeId < 0) {
            typeId = 0;
        }

        PageHelperUtil pageHelperUtil = new PageHelperUtil();
        pageHelperUtil.pageNum = pageNum;
        pageHelperUtil.pageSize = pageSize;
        pageHelperUtil.typeId = typeId;

        return pageHelperUtil;
    }

}
