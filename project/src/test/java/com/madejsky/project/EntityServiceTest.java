package com.madejsky.project;

import com.madejsky.project.Exceptions.RecordNotFoundException;
import com.madejsky.project.Models.Category;
import com.madejsky.project.Models.Expense;
import com.madejsky.project.Repository.EntityRepository;
import com.madejsky.project.Services.EntityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class EntityServiceTest {

    @Mock
    private EntityRepository repository;

    @InjectMocks
    private EntityService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddExpense() {
        Expense expenseToAdd = new Expense();
        expenseToAdd.setAmount(100.0);
        expenseToAdd.setCategory(Category.EDUCATION);
        when(repository.save(any(Expense.class))).thenReturn(expenseToAdd);
        Expense savedExpense = service.addExpense(expenseToAdd);

        assertEquals(100.0, savedExpense.getAmount());
        assertEquals(Category.EDUCATION, savedExpense.getCategory());

        verify(repository, times(1)).save(any(Expense.class));
    }

    @Test
    public void testGetAllExpenses() {
        List<Expense> mockExpenses = new ArrayList<>();
        mockExpenses.add(new Expense(100.0, Category.EDUCATION));
        mockExpenses.add(new Expense(200.0, Category.BILLS));
        when(repository.findAll()).thenReturn(mockExpenses);
        List<Expense> result = service.getAll();

        assertEquals(2, result.size());
        assertEquals(Category.EDUCATION, result.get(0).getCategory());
        assertEquals(Category.BILLS, result.get(1).getCategory());

        verify(repository, times(1)).findAll();
    }

    @Test
    public void testDeleteExistingExpenseById() throws RecordNotFoundException {
        Expense expenseToDelete = new Expense(100.0, Category.FOOD);
        expenseToDelete.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(expenseToDelete));
        service.deleteExpenseById(1L);

        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).deleteById(1L);
    }
    @Test
    public void testDeleteNonExistingExpenseById() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RecordNotFoundException.class, () -> service.deleteExpenseById(1L));
        verify(repository, times(1)).findById(1L);
        verify(repository, never()).deleteById(anyLong());
    }
    @Test
    public void testAddExpenseWithInvalidData() {
        Expense expenseToAdd = new Expense();
        expenseToAdd.setAmount(-100.0);
        expenseToAdd.setCategory(Category.EDUCATION);

        assertThrows(IllegalArgumentException.class, () -> service.addExpense(expenseToAdd));
        verify(repository, never()).save(any(Expense.class));
    }
    @Test
    public void testAddExpenseWithoutAmount() {
        Expense expenseToAdd = new Expense();
        expenseToAdd.setAmount(null);
        expenseToAdd.setCategory(Category.EDUCATION);

        assertThrows(IllegalArgumentException.class, () -> service.addExpense(expenseToAdd));
        verify(repository, never()).save(any(Expense.class));
    }


//    @Test
//    public void testDeleteExpenseById() {
//        Expense expenseToDelete = new Expense(100.0, Category.FOOD);
//        expenseToDelete.setId(1L);
//        when(repository.findById(1L)).thenReturn(Optional.of(expenseToDelete));
//
//        assertThrows(RecordNotFoundException.class, () -> service.deleteExpenseById(1L));
//        verify(repository, times(1)).findById(1L);
//        verify(repository, never()).deleteById(anyLong());
//    }
}
