package com.stage.dev.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

	
}
