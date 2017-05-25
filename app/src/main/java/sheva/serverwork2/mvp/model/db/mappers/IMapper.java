package sheva.serverwork2.mvp.model.db.mappers;

public interface IMapper<A, B> {
    B transform(A object) throws RuntimeException;
}