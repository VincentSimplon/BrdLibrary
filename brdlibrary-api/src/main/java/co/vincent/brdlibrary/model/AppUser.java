package co.vincent.brdlibrary.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "user")
public class AppUser {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "email")
//    @Email(message = "*Please provide a valid Email")
//    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Transient
    private String passwordConfirm;
    private String profilePicture;
    @Column(name="address_line_1")
	private String addressLine1;
	@Column(name="address_line_2")
	private String addressLine2;
	private String city;
	private String country;
	@Column(name="first_name")
	private String firstName;
    @Column(name = "user_name")
    @NotEmpty(message = "*Please provide your name")
    private String username;
//    @Column(name = "last_name")
//    @NotEmpty(message = "*Please provide your last name")
    private String lastName;
    @Column(name="zip_code")
	private String zipCode;
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> roleList;
    @ManyToMany
	@JoinTable(name="user_movie", joinColumns= @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="movie_id"))
    private List<Movie> movies;

    
    public AppUser(String username, String password, List<Role> roleList) {
    	// TODO Auto-generated constructor stub
    }
    public AppUser(String username, String password, String lastName, String email, List<Role> roleList) {
    	// TODO Auto-generated constructor stub
    }
    
    
	public AppUser(
			@NotEmpty(message = "*Please provide your name") String username,
		@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password ){
		super();
		this.password = password;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
	public List<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", passwordConfirm=" + passwordConfirm
				+ ", profilePicture=" + profilePicture + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", country=" + country + ", firstName=" + firstName + ", username="
				+ username + ", lastName=" + lastName + ", zipCode=" + zipCode + ", roleList=" + roleList + ", movies="
				+ movies + "]";
	}
	
	
	public AppUser(String email,
			@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			String profilePicture, String addressLine1, String addressLine2, String city, String country,
			String firstName, @NotEmpty(message = "*Please provide your name") String username, String lastName,
			String zipCode, List<Role> roleList, List<Movie> movies) {
		super();
		this.email = email;
		this.password = password;
		this.profilePicture = profilePicture;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.country = country;
		this.firstName = firstName;
		this.username = username;
		this.lastName = lastName;
		this.zipCode = zipCode;
		this.roleList = roleList;
		this.movies = movies;
	}
	public AppUser() {
		super();
	}
	public AppUser(
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
			@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			@NotEmpty(message = "*Please provide your name") String username,
			@NotEmpty(message = "*Please provide your last name") String lastName) {
		this(email, password, username, lastName, null, null, null, null, null, null, null, null, null);
	}
	public AppUser(
			@Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email,
			@Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password,
			@NotEmpty(message = "*Please provide your name") String username, List<Role> roleList) {
		this(email, password, username, null, null, null, null, null, null, null, null, roleList, null);
		
	}
    
	
    
} 