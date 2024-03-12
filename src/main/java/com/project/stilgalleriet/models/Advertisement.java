package com.project.stilgalleriet.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="advertisements")
public class Advertisement {

    @Id
    private String id;

    private String title;

    @DBRef
    private User user;

    public Advertisement() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // @DBRef //to reference to users collection
   // private User userId;      //must be changed this field and getters/ setters according to this field
    //@NotBlank(message="Field can not be blank")
    //private String userId;

   // @NotBlank(message="Field can not be blank")


   /* @NotBlank(message="Field can not be blank")
    private String description;


    @NotBlank(message="Field can not be blank")
    private EGender gender;


    @NotBlank(message="Field can not be blank")
    private ECategory category;

    @NotEmpty(message="Field can not be empty")
    private List<String > imgUrl;


    @NotBlank(message="Field can not be blank")
     private ESize size;

    @NotBlank(message="Field can not be blank")
     private EColor color;

    @NotBlank(message="Field can not be blank")
     private double price;

     private Date createdAt;

     private Date updatedAt;
*/
 //    private boolean isActive=true;


   /* public Advertisement() {
    }*/


    //public String getId() {
        //return id;
    //}

    //public void setId(String id) {
       // this.id = id;
    //}

    /*public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }*/

   /* public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }*/

    /*public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ESize getSize() {
        return size;
    }

    public void setSize(ESize size) {
        this.size = size;
    }

    public EColor getColor() {
        return color;
    }

    public void setColor(EColor color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
*/

   /* public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/
}
