# Automate
Automate project simulates automate machine with spring MVC project.
##  ##
In these project, you found implementation of two GOF Patterns. These patterns : 
>* Factory Pattern
>* State Pattern

While implementing these patterns, Spring-boot abilities are used as much as possible in project. For examples, when changing a state to another state, I took advantage of Spring beans. ___

For example:

```java
	@Override
	public SuccessMessage selectConsumable(AutomateContext context) throws AutomateException {
		Optional<Consumable> consumable = Optional.of(context.getTemporaryContext().getConsumable());
		if (consumable.isPresent()) {
			context.getCurrentContext().setConsumable(consumable.get());
            /**
            * After selection of consumable state, state of machine changes to Quantity state that enter how much consumable is ordered.
            **/
			context.setState(appContext.getBean(QuantityState.class));
		} else {
			throw new AutomateException("You must be choose consumable. ");
		}

		return new SuccessMessage("Consumable selected succesfully.", context.getCurrentContext());
	}
```
### State ###
As you can see below image, machine states is circular. Actually automate has start and stop state. Those states are "Consumable Selection State" and "Receipt State" sequentially. 

When a consumer uses automate, firstly s/he should be select consumable. If s/he select other states, eventually automate throws an error message to inform select current state. These case is same for other cases.

![Alt text](image/state.png?raw=true "Title")
