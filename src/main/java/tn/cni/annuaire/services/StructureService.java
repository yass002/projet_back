package tn.cni.annuaire.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cni.annuaire.dto.TreeNode;
import tn.cni.annuaire.entities.Structure;
import tn.cni.annuaire.repositrories.StructureRepository;
import tn.cni.annuaire.responses.MessageResponse;
import tn.cni.annuaire.responses.StructureResponse;

@Service
public class StructureService {

	@Autowired
	private StructureRepository structureRepository;
	private List<String> parents = new ArrayList<>();
	public MessageResponse save(Structure structure) {
		boolean exist = structureRepository.existsByNom(structure.getNom());
		if (exist) {
			return new MessageResponse(false, "Attention", "Nom structure existe déjà");
		}

		exist = structureRepository.existsByCode(structure.getCode());
		if (exist) {
			return new MessageResponse(false, "Attention", "Code structure existe déjà");
		}

		structureRepository.save(structure);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public MessageResponse update(Structure structure) {
		boolean exist = structureRepository.existsByNomAndId(structure.getNom(), structure.getId());
		if (!exist) {
			exist = structureRepository.existsByNom(structure.getNom());
			if (exist) {
				return new MessageResponse(false, "Attention", "Nom structure existe déjà");
			}
		}
		exist = structureRepository.existsByCodeAndId(structure.getCode(), structure.getId());
		if (!exist) {
			exist = structureRepository.existsByCode(structure.getCode());
			if (exist) {
				return new MessageResponse(false, "Attention", "Code structure existe déjà");
			}
		}
		structureRepository.save(structure);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public MessageResponse delete(Integer id) {

		structureRepository.deleteById(id);

		return new MessageResponse(true, "Succès", "Opération Effectué");

	}

	public List<StructureResponse> findAll() {
		List<StructureResponse> structureResponses = new ArrayList<StructureResponse>();
		List<Structure> list = structureRepository.findAll();
		list.forEach(str -> {
			StructureResponse structureResponse = new StructureResponse();
			structureResponse.setStructure(str);

//			//Structure parent = str.getParent();
//		
//			System.out.println("before while");
//			while((str.getParent()!=null)) {
//				System.out.println("arround while");
//				path += "/"+str.getNom();
//				str.setParent( str.getParent().getParent());
//				
//			}
//			System.out.println("after while");

			if (str.getParent() != null) {
				List<String> paths = getPathParent(str.getId());
				Collections.reverse(paths);
				String path = "";
				for (String p : paths) {
					path += "/" + p;
				}
				structureResponse.setPath(path);
			}

			structureResponses.add(structureResponse);
			parents  = new ArrayList<>();
		});
	
		return structureResponses;
	}

	public List<String> getPathParent(Integer id) {
		Structure parent = structureRepository.findById(id).orElse(null);
	
		
	
		

			if (parent.getParent() != null) {
				
				String path = "";
				path = parent.getParent().getNom();
				parents.add(path);
				getPathParent(parent.getParent().getId());	
			} 
		

		

		return parents;

	}

	public List<Structure> findParent() {
		return structureRepository.findByParentIsNull();
	}

	public List<Structure> findByParent(Integer id) {
		Structure parent = new Structure();
		parent.setId(id);
		return structureRepository.findByParent(parent);
	}

	public List<TreeNode> getStructure() {

		List<TreeNode> treeNodes = new ArrayList<>();
		List<Structure> parents = findParent();
		for (Structure parent : parents) {
			TreeNode treeNode = new TreeNode();
			treeNode.setKey(parent.getId());
			treeNode.setLabel(parent.getNom());

			treeNode.setChildren(getChildren(parent.getId()));

			treeNodes.add(treeNode);
		}

		return treeNodes;
	}

	public Structure getById(Integer id) {
		return structureRepository.findById(id).orElse(null);
	}

	public List<TreeNode> getChildren(Integer id) {
		List<Structure> childs = findByParent(id);
		List<TreeNode> children = new ArrayList<>();
		if (!childs.isEmpty()) {

			for (Structure child : childs) {
				TreeNode treeNodeChild = new TreeNode();
				treeNodeChild.setKey(child.getId());
				treeNodeChild.setLabel(child.getNom());
				// child.getid : id mta3 parent
				treeNodeChild.setChildren(getChildren(child.getId()));
				;
				children.add(treeNodeChild);

			}

		}
		return children;

	}

}
