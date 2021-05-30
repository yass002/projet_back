package tn.cni.annuaire.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageResponse {
	
	private boolean success;
	private String message;
	private String detail;

}
