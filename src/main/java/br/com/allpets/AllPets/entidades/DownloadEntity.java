package br.com.allpets.AllPets.entidades;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public class DownloadEntity extends HttpEntity<byte[]> {

    private HttpEntity<byte[]> httpEntity;

    public DownloadEntity(byte[] bytes, String fileName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-disposition", "attachment; filename=\""+fileName+"\"");
        httpEntity = new HttpEntity<byte[]>(bytes, httpHeaders);
    }

    public HttpHeaders getHeaders() {
        return httpEntity.getHeaders();
    }

    public byte[] getBody() {
        return httpEntity.getBody();
    }

    public boolean hasBody() {
        return httpEntity.hasBody();
    }

    public boolean equals(Object other) {
        return httpEntity.equals(other);
    }

    public int hashCode() {
        return httpEntity.hashCode();
    }

    public String toString() {
        return httpEntity.toString();
    }
}