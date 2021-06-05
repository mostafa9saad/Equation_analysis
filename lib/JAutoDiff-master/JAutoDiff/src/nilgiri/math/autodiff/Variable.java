package nilgiri.math.autodiff;

import nilgiri.math.AbstractIdentityFactory;
import nilgiri.math.Field;

/** Variables in X forms a field.
 * @author uniker9
 *
 * @param <X> A set forms a field.
 */
public class Variable<X extends Field<X>> extends DifferentialFunction<X> {

	private X m_x;
	private AbstractIdentityFactory<X> m_factory;
	private String m_name;


	protected Variable(String i_name, X i_v,
			AbstractIdentityFactory<X> i_factory) {
		setName(i_name);
		if (i_v != null && i_factory != null) {
			m_x = i_v;
			m_factory = i_factory;
		} else {
			throw new IllegalArgumentException("Input not null value.");
		}
	}

	protected AbstractIdentityFactory<X> factory() {
		return m_factory;
	}

	private void setName(String i_name) {
		if (i_name != null) {
			m_name = i_name;// new String(i_name);
		} else {
			throw new IllegalArgumentException("Input not null value.");
		}
	}

	/** Returns the name of this variable. 
	 * @return the name.
	 */
	public String getName() {
		return m_name;
	}

	/** Set this value to i_v.
	 * @param i_v
	 */
	public void set(X i_v) {
		if (i_v != null) {
			m_x = i_v;
		} else {
			throw new IllegalArgumentException("Input not null value.");
		}
	}

	@Override
	public boolean isVariable() {
		return true;
	}

	@Override
	public X getValue() {
		return m_x;
	}

	@Override
	public Constant<X> diff(Variable<X> i_v) {
		return (this == i_v) ? new One<X>(m_factory) : new Zero<X>(m_factory);
	}

	@Override
	public String toString() {
		return getName();
	}

	public DifferentialFunction<X> div(DifferentialFunction<X> i_v) {
		return (i_v == this) ? new One<X>(m_factory) : super.mul(i_v.inverse());
	}
	
}