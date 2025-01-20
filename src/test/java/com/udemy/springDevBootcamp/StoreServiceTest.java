package com.udemy.springDevBootcamp;

import com.udemy.springDevBootcamp.repository.StoreRepository;
import com.udemy.springDevBootcamp.service.StoreService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceTest {

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;
}
