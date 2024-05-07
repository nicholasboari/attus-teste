package nicholasboari.com.attusteste.dto;

import nicholasboari.com.attusteste.dto.request.CreateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.request.UpdateAddressRequestDTO;
import nicholasboari.com.attusteste.dto.response.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DTOWithoutBirthdayTest {

    @Test
    @DisplayName("Test DTO's getter setter")
    void testAllDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(CreateAddressRequestDTO.class);
        beanTester.testBean(UpdateAddressRequestDTO.class);

        beanTester.testBean(AddressResponseDTO.class);
        beanTester.testBean(CreateAddressResponseDTO.class);
        beanTester.testBean(UpdateAddressResponseDTO.class);
    }
}
