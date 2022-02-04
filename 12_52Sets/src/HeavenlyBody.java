/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    //private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final Key key;

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyTypes) {
        this.key = new Key(name, bodyTypes);;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObj = (HeavenlyBody) obj;
            if (this.key.name.equals(theObj.key.name)) {
                return this.key.bodyType == theObj.key.bodyType;
            }
        }

        return false;
    }

    @Override
    public final int hashCode() {
        System.out.println("hashcode called");
        return this.getKey().getName().hashCode() + 57;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj instanceof Key) {
                Key theObj = (Key) obj;
                if (this.name.equals(theObj.name)) {
                    return this.bodyType == theObj.bodyType;
                }
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 1234;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}