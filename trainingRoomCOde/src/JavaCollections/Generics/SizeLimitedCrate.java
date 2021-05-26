package JavaCollections.Generics;

public class SizeLimitedCrate<T, U> {
    //T represents type of content in crate
    //U represents measuring unit for maximum size of crate
    private T contents;
    private U sizeLimit;

    public SizeLimitedCrate(T contents, U sizeLimit){
        this.contents = contents;
        this.sizeLimit = sizeLimit;
    }
}
