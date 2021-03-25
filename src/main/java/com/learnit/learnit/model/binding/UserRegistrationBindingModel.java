package com.learnit.learnit.model.binding;


import com.learnit.learnit.model.validators.FieldMatch;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@FieldMatch(
    first = "password",
    second = "confirmPassword"
)
public class UserRegistrationBindingModel {

  @NotEmpty(message = "Username cannot be empty.")
  @Size(min = 3, message = "Username must be minimum 3 characters long.")
  private String username;
  @NotEmpty(message = "Email cannot be empty.")
  @Email(message = "Invalid email.")
  private String email;
  @NotEmpty(message = "Password cannot be empty.")
  @Size(min = 5, max = 20, message = "Password must be between 3 and 20 characters long.")
  private String password;
  @NotEmpty(message = "Password cannot be empty.")
  private String confirmPassword;

  public String getUsername() {
    return username;
  }

  public UserRegistrationBindingModel setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public UserRegistrationBindingModel setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public UserRegistrationBindingModel setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public UserRegistrationBindingModel setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
    return this;
  }
}
