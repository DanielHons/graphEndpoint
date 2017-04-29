            var App = React.createClass({

          loadPersonsFromServer: function () {
            var self = this;
            $.ajax({
              url: "http://localhost:9000/api/person/list"
            }).then(function (data) {
              self.setState({persons: data});
            });
          },

          getInitialState: function () {
            return {persons: []};
          },

          componentDidMount: function () {
            this.loadPersonsFromServer();
          },

          render() {
            return ( <PersonTable persons={this.state.persons}/> );
          }
        });

        var Person = React.createClass({
          getInitialState: function() {
              return {display: true };
          },
          handleDelete() {
                var self = this;
                $.ajax({
                  url: "http://localhost:9000/api/person/"+this.props.person.id,
                  type: 'DELETE',
                  success: function(result) {
                    self.setState({display: false});
                  },
                  error: function(xhr, ajaxOptions, thrownError) {
                    toastr.error(xhr.responseJSON.message);
                  }
                });
          },
          render: function() {
            if (this.state.display==false) return null;
            return (
              <tr>
                <td>{this.props.person.firstName}</td>
                <td>{this.props.person.lastName}</td>
                <td>{this.props.person.email}</td>
                <td>
                  <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
                </td>
              </tr>);
          }
        });
        var PersonTable = React.createClass({
          render: function() {
            var rows = [];
            this.props.persons.forEach(function(person) {
              rows.push(<Person person={person} />);
            });
            return (
                <div className="container">
                  <table className="table table-striped">
                    <thead>
                      <tr>
                        <th>Vorname</th>
                        <th>Nachname</th>
                        <th>E-Mail</th>
                        <th>Delete</th>
                      </tr>
                    </thead>
                    <tbody>{rows}</tbody>
                  </table>
                </div>
              );
          }
        });


        var PERSONS = [
          {key:1,firstName: 'Joe', lastName: 'Biden', email: '45', years: 5}

        ];

        ReactDOM.render(
          <App/>, document.getElementById('root')
        );