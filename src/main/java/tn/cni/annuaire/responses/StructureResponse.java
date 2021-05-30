package tn.cni.annuaire.responses;

import lombok.Data;
import tn.cni.annuaire.entities.Structure;

@Data
public class StructureResponse {
	
	private String path;
	private Structure structure;
}
