package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Kangaroo {
    private long id;
    private String name;
    private double height;
    private double weight;

    private String gender;
    private boolean isAggressive;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public double getHeight() {
        return this.height;
    }

    public String getGender() {
        return this.gender;
    }

    public boolean isAggressive() {
        return this.isAggressive;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Kangaroo)) return false;
        final Kangaroo other = (Kangaroo) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (Double.compare(this.getWeight(), other.getWeight()) != 0) return false;
        if (Double.compare(this.getHeight(), other.getHeight()) != 0) return false;
        final Object this$gender = this.getGender();
        final Object other$gender = other.getGender();
        if (this$gender == null ? other$gender != null : !this$gender.equals(other$gender)) return false;
        if (this.isAggressive() != other.isAggressive()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Kangaroo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final long $weight = Double.doubleToLongBits(this.getWeight());
        result = result * PRIME + (int) ($weight >>> 32 ^ $weight);
        final long $height = Double.doubleToLongBits(this.getHeight());
        result = result * PRIME + (int) ($height >>> 32 ^ $height);
        final Object $gender = this.getGender();
        result = result * PRIME + ($gender == null ? 43 : $gender.hashCode());
        result = result * PRIME + (this.isAggressive() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "Kangaroo(id=" + this.getId() + ", name=" + this.getName() + ", weight=" + this.getWeight() + ", height=" + this.getHeight() + ", gender=" + this.getGender() + ", isAggressive=" + this.isAggressive() + ")";
    }
}
