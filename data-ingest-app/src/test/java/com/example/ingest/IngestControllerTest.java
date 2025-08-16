import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.ingest.controller.IngestController;
import com.example.ingest.dto.RecordDto;
import com.example.ingest.service.IngestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(IngestController.class)
public class IngestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private IngestService ingestService;

    @InjectMocks
    private IngestController ingestController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testIngestData() throws Exception {
        RecordDto recordDto = new RecordDto();
        recordDto.setName("Test Record");
        recordDto.setTimestamp(System.currentTimeMillis());

        when(ingestService.saveRecord(any(RecordDto.class))).thenReturn(null);

        mockMvc.perform(post("/api/ingest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(recordDto)))
                .andExpect(status().isOk());

        verify(ingestService, times(1)).saveRecord(any(RecordDto.class));
    }
}