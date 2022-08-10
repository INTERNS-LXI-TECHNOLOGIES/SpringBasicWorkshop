package main.java.com.lxisoft.vegetable;

import org.springframework.web.multipart.MultipartFile;

public class VegetableMultipart extends Vegetable{

private MultipartFile imageFile;

public MultipartFile getImageFile() {

    return imageFile;
}

public void setImageFile(MultipartFile imageFile){

    this.imageFile=imageFile;
}

}