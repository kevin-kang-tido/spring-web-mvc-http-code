package co.istad.diresource.dto;

public record ProductRequest(
        String uuid,
        Integer id,
        String name,
        Double price,
        Integer qty

) {



}
