package co.istad.diresource.dto;

public record ProductEditRequest(
        String name,
        String uuid,
        Double price

) {
}
