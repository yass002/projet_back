package tn.cni.annuaire.dto;

import java.util.List;

import lombok.Data;

@Data
public class TreeNode {
	
	private Integer key;
	private String label;
//	private TreeNode parent;
	private List<TreeNode> children;

}
