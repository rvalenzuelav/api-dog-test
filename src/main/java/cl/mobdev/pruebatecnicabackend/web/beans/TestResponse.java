package cl.mobdev.pruebatecnicabackend.web.beans;

import java.util.List;

public class TestResponse {

    private String breed;
    private List<String> subBreeds;
    private List<String> images;

    public String getBreed() {
        return breed;
    }

    public List<String> getSubBreeds() {
        return subBreeds;
    }

    public List<String> getImages() {
        return images;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setSubBreeds(List<String> subBreeds) {
        this.subBreeds = subBreeds;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "{" +
                "breed='" + breed + '\'' +
                ", subBreeds=" + subBreeds +
                ", images=" + images +
                '}';
    }
}

