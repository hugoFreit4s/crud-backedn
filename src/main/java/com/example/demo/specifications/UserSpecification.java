package com.example.demo.specifications;

import com.example.demo.model.User;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;


public class UserSpecification {
    public static Specification<User> filter(String gender, String age) {
        return (root, _, criteriaBuilder) -> {
            Predicate genderPredicate = criteriaBuilder.equal(root.get("gender"), gender);
            Predicate agePredicate = criteriaBuilder.equal(root.get("age"), Integer.parseInt(age));
            return criteriaBuilder.and(genderPredicate, agePredicate);
        };
    }
}