import React from 'react';

class Register extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email: '',
      password: '',
      errors: {
        fullName: '',
        email: '',
        password: ''
      }
    };
  }

  handleChange = (event) => {
    let { name, value } = event.target;
    let errors = this.state.errors;

    switch (name) {
      case 'fullName':
        errors.fullName = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        errors.email = (!value.includes('@') || !value.includes('.')) ? 'Email is not valid!' : '';
        break;
      case 'password':
        errors.password = value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    this.setState({ errors, [name]: value });
  };

  validateForm = (errors) => {
    let valid = true;
    Object.values(errors).forEach(val => val.length > 0 && (valid = false));
    return valid;
  };

  handleSubmit = (event) => {
    event.preventDefault();
    if (this.validateForm(this.state.errors)) {
      alert('Valid Form');
    } else {
      alert(Object.values(this.state.errors).filter(err => err).join('\n'));
    }
  };

  render() {
    return (
      <div style={{ padding: '20px' }}>
        <h1 style={{ color: 'red' }}>Register Here!!!</h1>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name:</label>
            <input type="text" name="fullName" onChange={this.handleChange} />
          </div>
          <div>
            <label>Email:</label>
            <input type="text" name="email" onChange={this.handleChange} />
          </div>
          <div>
            <label>Password:</label>
            <input type="password" name="password" onChange={this.handleChange} />
          </div>
          <div>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default Register;
