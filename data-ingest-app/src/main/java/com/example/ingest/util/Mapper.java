public class Mapper {

    public static RecordDto toDto(RecordEntity entity) {
        if (entity == null) {
            return null;
        }
        RecordDto dto = new RecordDto();
        dto.setName(entity.getName());
        dto.setTimestamp(entity.getTimestamp());
        return dto;
    }

    public static RecordEntity toEntity(RecordDto dto) {
        if (dto == null) {
            return null;
        }
        RecordEntity entity = new RecordEntity();
        entity.setName(dto.getName());
        entity.setTimestamp(dto.getTimestamp());
        return entity;
    }
}