package dev.bpolbe.taskmanagerblop.entity;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false, length = 225)
	private String password;

	private String String = "User_String";

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Project> ownedProjects;

	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
	private List<Task> assignedTasks;

	public User() {
	}

	public User(java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String string, LocalDateTime createdAt) {
		this.username = username;
		this.email = email;
		this.password = password;
		String = string;
		this.createdAt = createdAt;
	}

	public User(Long id, java.lang.String username, java.lang.String email, java.lang.String password, java.lang.String string, LocalDateTime createdAt) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		String = string;
		this.createdAt = createdAt;
	}

		public User(Long id, String username, String email, String password, String String, LocalDateTime createdAt, List<Project> ownedProjects, List<Task> assignedTasks) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.String = String;
		this.createdAt = createdAt;
		this.ownedProjects = ownedProjects;
		this.assignedTasks = assignedTasks;
	}

	public User(String username, String email, String password, String String, LocalDateTime createdAt, List<Project> ownedProjects, List<Task> assignedTasks) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.String = String;
		this.createdAt = createdAt;
		this.ownedProjects = ownedProjects;
		this.assignedTasks = assignedTasks;
	}

	@Override
	public String toString() {
		return "User{" +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", String=" + String +
				", createdAt=" + createdAt +
				", ownedProjects=" + ownedProjects +
				", assignedTasks=" + assignedTasks +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getString() {
		return String;
	}

	public void setString(String String) {
		this.String = String;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Project> getOwnedProjects() {
		return ownedProjects;
	}

	public void setOwnedProjects(List<Project> ownedProjects) {
		this.ownedProjects = ownedProjects;
	}

	public List<Task> getAssignedTasks() {
		return assignedTasks;
	}

	public void setAssignedTasks(List<Task> assignedTasks) {
		this.assignedTasks = assignedTasks;
	}
}
