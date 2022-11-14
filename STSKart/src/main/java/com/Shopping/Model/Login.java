package com.Shopping.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {

	@Email
	private String email;
	
	@NotBlank(message="Enter a valid Password")
	@NotEmpty(message="Enter a valid Password")
	@NotNull(message="Enter a valid Password")
	private String password;
}
