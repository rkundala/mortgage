import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ingest.model.RecordEntity;
import com.example.ingest.repository.RecordRepository;
import com.example.ingest.service.IngestService;
import com.example.ingest.dto.RecordDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class IngestServiceTest {

    @InjectMocks
    private IngestService ingestService;

    @Mock
    private RecordRepository recordRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveRecord() {
        RecordDto recordDto = new RecordDto();
        recordDto.setName("Test Record");

        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setId(1L);
        recordEntity.setName(recordDto.getName());

        when(recordRepository.save(any(RecordEntity.class))).thenReturn(recordEntity);

        RecordEntity savedRecord = ingestService.saveRecord(recordDto);

        assertNotNull(savedRecord);
        assertEquals("Test Record", savedRecord.getName());
        verify(recordRepository, times(1)).save(any(RecordEntity.class));
    }

    @Test
    public void testFindRecordById() {
        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setId(1L);
        recordEntity.setName("Test Record");

        when(recordRepository.findById(1L)).thenReturn(Optional.of(recordEntity));

        Optional<RecordEntity> foundRecord = ingestService.findRecordById(1L);

        assertTrue(foundRecord.isPresent());
        assertEquals("Test Record", foundRecord.get().getName());
        verify(recordRepository, times(1)).findById(1L);
    }

    @Test
    public void testRecordNotFound() {
        when(recordRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<RecordEntity> foundRecord = ingestService.findRecordById(1L);

        assertFalse(foundRecord.isPresent());
        verify(recordRepository, times(1)).findById(1L);
    }
}