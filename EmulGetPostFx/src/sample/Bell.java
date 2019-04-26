package sample;

import java.time.LocalDateTime;

public class Bell {

    private Long id;
    private LocalDateTime creationDate;

    public Bell() {
    }

    public Bell(Long id, LocalDateTime creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Bell{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bell bell = (Bell) o;

        if (!id.equals(bell.id)) return false;
        return creationDate.equals(bell.creationDate);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + creationDate.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
