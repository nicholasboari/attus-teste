package nicholasboari.com.attusteste.repository;

import nicholasboari.com.attusteste.model.Person;
import nicholasboari.com.attusteste.util.PersonCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @DisplayName("Save creates person when successful")
    @Test
    void save_PersistPerson_WhenSuccessful(){
        Person personToBeSaved = PersonCreator.createAValidPersonResponseDTO();

        Person personSaved = this.personRepository.save(personToBeSaved);

        assertThat(personSaved).isNotNull();
        assertThat(personSaved.getId()).isNotNull();
        assertThat(personSaved.getName()).isEqualTo(personToBeSaved.getName());
        assertThat(personSaved.getBirthday()).isEqualTo(personToBeSaved.getBirthday());
        assertThat(personSaved.getAddresses()).isEqualTo(personToBeSaved.getAddresses());
    }

    @DisplayName("Find by ID returns person when exists")
    @Test
    void findById_ReturnsPerson_WhenExists() {
        Person personToBeSaved = PersonCreator.createAValidPersonResponseDTO();
        Person savedPerson = personRepository.save(personToBeSaved);

        Optional<Person> foundPersonOptional = personRepository.findById(savedPerson.getId());

        assertThat(foundPersonOptional).isNotEmpty();
        assertThat(foundPersonOptional.get()).isEqualTo(savedPerson);
    }

    @DisplayName("Find by ID returns empty optional when person does not exist")
    @Test
    void findById_ReturnsEmptyOptional_WhenPersonDoesNotExist() {
        Optional<Person> foundPersonOptional = personRepository.findById("nonexistent-id");

        assertThat(foundPersonOptional).isEmpty();
    }

    @DisplayName("Find all returns list of persons")
    @Test
    void findAll_ReturnsListOfPersons() {
        personRepository.save(PersonCreator.createAValidPersonResponseDTO());
        personRepository.save(PersonCreator.createAValidPersonResponseDTO());

        Iterable<Person> allPersons = personRepository.findAll();

        assertThat(allPersons).isNotEmpty();
    }

    @DisplayName("Update updates person when successful")
    @Test
    void update_UpdatesPerson_WhenSuccessful() {
        Person personToBeSaved = PersonCreator.createAValidPersonResponseDTO();
        Person savedPerson = personRepository.save(personToBeSaved);

        savedPerson.setName("Updated Name");

        Person updatedPerson = personRepository.save(savedPerson);

        assertThat(updatedPerson).isNotNull();
        assertThat(updatedPerson.getId()).isEqualTo(savedPerson.getId());
        assertThat(updatedPerson.getName()).isEqualTo("Updated Name");
    }

    @DisplayName("Delete removes person when successful")
    @Test
    void delete_RemovesPerson_WhenSuccessful() {
        Person personToBeSaved = PersonCreator.createAValidPersonResponseDTO();
        Person savedPerson = personRepository.save(personToBeSaved);

        personRepository.delete(savedPerson);

        Optional<Person> deletedPersonOptional = personRepository.findById(savedPerson.getId());

        assertThat(deletedPersonOptional).isEmpty();
    }
}