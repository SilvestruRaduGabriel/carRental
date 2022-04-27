package ro.sda.finalProject.carRental.mappers;




public interface Mapper <E,D>{

    D convertToDto(E entity);
    E convertToEntity(D dto);


}
