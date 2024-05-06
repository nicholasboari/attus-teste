package nicholasboari.com.attusteste.repository;

import nicholasboari.com.attusteste.model.Address;
import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.util.AddressCreator;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @DisplayName("Save creates address when successful")
    @Test
    void save_PersistAddress_WhenSuccessful() {
        Address addressToBeSaved = AddressCreator.createAValidAddressResponseDTO();

        Address savedAddress = addressRepository.save(addressToBeSaved);

        assertThat(savedAddress).isNotNull();
        assertThat(savedAddress.getId()).isNotNull();
    }

    @DisplayName("Find by ID returns address when exists")
    @Test
    void findById_ReturnsAddress_WhenExists() {
        Address addressToBeSaved = AddressCreator.createAValidAddressResponseDTO();
        Address savedAddress = addressRepository.save(addressToBeSaved);

        Optional<Address> foundAddressOptional = addressRepository.findById(savedAddress.getId());

        assertThat(foundAddressOptional).isNotEmpty();
        assertThat(foundAddressOptional.get()).isEqualTo(savedAddress);
    }

    @DisplayName("Find by ID returns empty optional when address does not exist")
    @Test
    void findById_ReturnsEmptyOptional_WhenAddressDoesNotExist() {
        Optional<Address> foundAddressOptional = addressRepository.findById("nonexistent-id");

        assertThat(foundAddressOptional).isEmpty();
    }

    @DisplayName("Find all returns list of addresses")
    @Test
    void findAll_ReturnsListOfAddresses() {
        addressRepository.save(AddressCreator.createAValidAddressResponseDTO());
        addressRepository.save(AddressCreator.createAValidAddressResponseDTO());

        Iterable<Address> allAddresses = addressRepository.findAll();

        assertThat(allAddresses).isNotEmpty();
    }

    @DisplayName("Update updates address when successful")
    @Test
    void update_UpdatesAddress_WhenSuccessful() {
        Address addressToBeSaved = AddressCreator.createAValidAddressResponseDTO();
        Address savedAddress = addressRepository.save(addressToBeSaved);

        savedAddress.setCity("Updated City");

        Address updatedAddress = addressRepository.save(savedAddress);

        assertThat(updatedAddress).isNotNull();
        assertThat(updatedAddress.getId()).isEqualTo(savedAddress.getId());
        assertThat(updatedAddress.getCity()).isEqualTo("Updated City");
    }

    @DisplayName("Delete removes address when successful")
    @Test
    void delete_RemovesAddress_WhenSuccessful() {
        Address addressToBeSaved = AddressCreator.createAValidAddressResponseDTO();
        Address savedAddress = addressRepository.save(addressToBeSaved);

        addressRepository.delete(savedAddress);

        Optional<Address> deletedAddressOptional = addressRepository.findById(savedAddress.getId());

        assertThat(deletedAddressOptional).isEmpty();
    }
}