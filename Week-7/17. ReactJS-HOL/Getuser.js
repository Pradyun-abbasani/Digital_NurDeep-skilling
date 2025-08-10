import React from 'react';

class Getuser extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch("https://api.randomuser.me/");
      const data = await response.json();
      this.setState({ user: data.results[0] });
    } catch (error) {
      console.error("Error fetching user:", error);
    }
  }

  render() {
    const { user } = this.state;

    return (
      <div style={{ textAlign: "center", padding: "20px" }}>
        <h1>User Details</h1>
        {user ? (
          <div>
            <p>
              {user.name.title} {user.name.first}
            </p>
            <img src={user.picture.large} alt="User" style={{ borderRadius: "50%" }} />
          </div>
        ) : (
          <p>Loading...</p>
        )}
      </div>
    );
  }
}

export default Getuser;
