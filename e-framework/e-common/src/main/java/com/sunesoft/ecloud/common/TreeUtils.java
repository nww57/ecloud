package com.sunesoft.ecloud.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: jiangzhenjing
 * @date: 2018/3/29 下午6:56
 * -
 */
public class TreeUtils {


    /**
     * 将list转成树形结构
     * 使用递归方法建树
     */
    public static <T extends TreeEntity> List<T> transformationTree(List<T> list) {
        List<T> trees = new ArrayList<T>();
        for (T treeNode : list) {//找到根节点
            if (treeNode.getPid() == null) {
                trees.add(findChildren(treeNode, list));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     */
    public static <T extends TreeEntity> T findChildren(T treeNode, List<T> list) {
        for (T it : list) {
            if (it.getPid() == null)//如果是顶级节点
                continue;
            if (treeNode.getChildren() == null) {
                treeNode.setChildren(new ArrayList<T>());
            }
            if (treeNode.getId().equals(it.getPid())) {//查到的节点是当前节点treeNode的子节点
                treeNode.getChildren().add(findChildren(it, list));
            }

        }
        return treeNode;
    }

}
