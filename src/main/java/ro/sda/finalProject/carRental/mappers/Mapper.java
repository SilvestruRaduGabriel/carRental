package ro.sda.finalProject.carRental.mappers;




public interface Mapper <E,D>{

    //LEGATURA CU INTERFATA (HTML)
    D convertToDto(E entity);

    // LEGATURA CU BAZA DE DATE
    E convertToEntity(D dto);


}
