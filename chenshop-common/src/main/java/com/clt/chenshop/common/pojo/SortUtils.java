package com.clt.chenshop.common.pojo;

import java.util.List;

/**
 * @program: chenshop
 * @description:
 * @author: Mr.Chen
 * @create: 2018-12-10 17:07
 **/
public class SortUtils {
    /**
     * 内容分类排序
     * @param list 空的集合（排序后的数据）
     * @param sourceList 源数据集合
     * @param parentId 父节点 ID
     * @param cascade 是否包含子节点
     */
    public static void sortContentCategoryList(List<TbContentCategory> list, List<TbContentCategory> sourceList, Long parentId, boolean cascade) {
        for (int i = 0; i < sourceList.size(); i++) {
            TbContentCategory e = sourceList.get(i);
            if (e.getParentId() != null && e.getParentId() == parentId) {
                list.add(e);
                if (cascade) {
                    // 判断是否还有子节点, 有则继续获取子节点
                    for (int j = 0; j < sourceList.size(); j++) {
                        TbContentCategory child = sourceList.get(j);
                        if (child.getParentId() != null && child.getParentId() == e.getId()) {
                            sortContentCategoryList(list, sourceList, e.getId(), true);
                            break;
                        }
                    }
                }
            }
        }
    }

}
