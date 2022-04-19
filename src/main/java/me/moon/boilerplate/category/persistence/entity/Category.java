package me.moon.boilerplate.category.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.boilerplate.common.model.BaseTimeEntity;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "category")
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category")
    private Category parent;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Category> children;

    @Builder
    public Category(String name, Category category){
        this.name = name;
        this.parent = category;
    }

    public void changeCategoryName(String name){
        this.name = name;
    }
}