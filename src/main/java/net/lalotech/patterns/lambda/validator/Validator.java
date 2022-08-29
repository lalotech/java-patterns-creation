package net.lalotech.patterns.lambda.validator;

import net.lalotech.patterns.lambda.validator.model.User;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Validator {
    ValidatorSupplier on(User u);

    default Validator thenValidate(Predicate<User> predicate,String errorMessage){
        return u -> {
            try {
                on(u).validate();
                if(predicate.test(u)){
                    return () -> u;
                }else {
                    return () -> {
                        //throw  new IllegalArgumentException(errorMessage);
                        IllegalArgumentException exception = new IllegalArgumentException("object is invalid");
                        exception.addSuppressed(new IllegalArgumentException(errorMessage));
                        throw exception;
                    };
                }
            }catch (IllegalArgumentException exception){
                if(predicate.test(u)){
                    //first case has error but second pass - throw the first error
                    return ()->{ throw exception;};
                }else{
                    //both validations have errors so need to suppress the exception then throw it
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    return ()->{ throw exception;};
                }
            }
        };
    }
    static Validator validate(Predicate<User> predicate,String errorMessage){
        return u -> {
            if(predicate.test(u)){
                return () -> u;
            }else{
                return () -> {
                    //throw  new IllegalArgumentException(errorMessage);
                    IllegalArgumentException exception = new IllegalArgumentException("object is invalid");
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                };
            }
        };
    }

    interface ValidatorSupplier extends Supplier<User> {
        default User validate(){
            return get();
        }
    }
}
