import React from 'react';

class CountPeople extends React.Component {
  constructor() {
    super();
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '100px' }}>
        <button onClick={this.updateEntry} style={styles.button}>
          Login
        </button>
        <span style={styles.text}>
          {this.state.entrycount} People Entered!!!
        </span>

        <button onClick={this.updateExit} style={{ ...styles.button, marginLeft: '40px' }}>
          Exit
        </button>
        <span style={styles.text}>
          {this.state.exitcount} People Left!!!
        </span>
      </div>
    );
  }
}

const styles = {
  button: {
    backgroundColor: 'lightgreen',
    border: '1px solid green',
    padding: '10px 20px',
    cursor: 'pointer',
    marginRight: '10px',
    fontWeight: 'bold'
  },
  text: {
    margin: '0 10px',
    fontSize: '18px',
    color: '#444'
  }
};

export default CountPeople;
