// The abstract class that represents financial assets the DI holds.
public abstract class Asset {
    // Returns the current market value of this Asset.

    public abstract double getMarketValue();

    // Returns a string representation of this Asset.
    public abstract String toString();

    // Returns the name of this Asset
    public abstract String getName();
}